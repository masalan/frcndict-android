Chinese French Dictionary For Android
=====================================

Free Chinese-French Dictionary for Android devices.
Released under the BSD license.

Any feedback is highly appreciated!


Build project
-------------

- Go to the project root directory and type `android update project --path .` to specify the sdk directory (only required once).
- Run the `ant release` command.


Modify the project configuration
--------------------------------

- Open the `ant.properties` file and modify it if needed
- Run the `ant config` command to include the previously modified configuration to the Java project.


Dictionary data
----------------

- This project uses a modified version of the [CFDICT](http://www.chine-informations.com/chinois/open/CFDICT/) dictionary.
- To generate dictionary data, please see the **dbparser** git branch.
- You will also have to modify the `DATABASE_VERSION` number in the `DictDbHelper` class.


Steps to do before releasing the application
---------------------------------------------

- Update `versionCode` and `versionName` in the `AndroidManifest.xml` file
- Update dictionary data
- Open `ant.properties`, set `logging.level=0` and the `database.version`
- Launch `ant clean config release`
- Sign application and run `zipalign` (See Android Developers Documentation)


Screenshots
-----------

<img src="https://raw.githubusercontent.com/Nilhcem/frcndict-android/master/screenshot.png" width="640" height="480" />


Contact me
----------

Use my github's nickname (at) gmail (dot) com
