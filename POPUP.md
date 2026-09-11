# POPUP 

## question and processes
## By Using Appium inspector and Appium eclipse represent handling popups coming int the apk's ?

### LINK TO ALL DOCS
*
*
----------------------------------------

 need to dowload apk ---> already in andriod emulator

--------------------

# here is to setup the adb 
```
set "PATH=C:\Users\hp\AppData\Local\Android\Sdk\platform-tools;%PATH%"
adb --version
adb devices

```

# to setup appium

```

set "PATH=%APPDATA%\npm;%PATH%"
appium --version
appium driver list --installed

Appium

```

# To install APk

```
adb install "C:\Users\hp\Downloads\Student+Exam+Results_2.0.3_APKPure.apk"  <--- to install apk in emulator

adb shell pm list packages | findstr /i exam

adb shell am start -n com.ega.examresult/.MainActivity

adb shell dumpsys window | findstr mCurrentFocus

```