package com.nilhcem.frcndict.search;

import android.content.Context;

import com.nilhcem.frcndict.core.Log;
import com.nilhcem.frcndict.core.list.AbstractSearchService;
import com.nilhcem.frcndict.database.DictDbHelper;
import com.nilhcem.frcndict.utils.ChineseCharsHandler;

public final class SearchService extends AbstractSearchService {

	public static final int BACK_TO_EXIT_TIMER = 4000;
	private static final String TAG = "SearchService";

	private long mLastBackPressTime = 0l;
	private final Context mContext;

	public SearchService(Context context) {
		super();
		mContext = context;
		mSearchType = AbstractSearchService.SEARCH_UNDEFINED;
	}

	public void setLastBackPressTime(long value) {
		mLastBackPressTime = value;
	}

	public boolean isBackBtnPressedForTheFirstTime() {
		return (mLastBackPressTime < System.currentTimeMillis() - SearchService.BACK_TO_EXIT_TIMER);
	}

	@Override
	public void detectAndSetSearchType(String search) {
		if (mSearchType == AbstractSearchService.SEARCH_UNDEFINED) {
			// Checks if search is in hanzi
			boolean isHanzi = false;
			for (char ch : search.toCharArray()) {
				if (ChineseCharsHandler.getInstance().charIsChinese(ch)) {
					mSearchType = AbstractSearchService.SEARCH_HANZI;
					isHanzi = true;
					break;
				}
			}

			if (!isHanzi) {
				// Determines if search is in pinyin or in french
				DictDbHelper db = new DictDbHelper(mContext);
				if (db.isPinyin(search)) {
					mSearchType = AbstractSearchService.SEARCH_PINYIN;
				} else {
					mSearchType = AbstractSearchService.SEARCH_FRENCH;
				}
				db.close();
			}

			Log.d(SearchService.TAG, "[Search type] Detected: %s",
				(mSearchType == AbstractSearchService.SEARCH_HANZI ? "Hanzi"
					: (mSearchType == AbstractSearchService.SEARCH_PINYIN ? "Pinyin"
						: (mSearchType == AbstractSearchService.SEARCH_FRENCH ? "French" : "Undefined"))));
		}
	}
}
