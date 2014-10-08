set HOME=%0\..

set APP_FILE=%HOME%\SemaphoreApp.jar
set APP_CLS=com\epam\mentoring\lessone\app

set LOG_FILE=%HOME%\SemaphoreLogin.jar
set LOG1_CLS=com\epam\mentoring\lessone\module
set LOG2_CLS=com\epam\mentoring\lessone\principal

set SEM_FILE=%HOME%\Semaphore.jar
set SEM_CLS=com\epam\mentoring\lessone\semaphore

set ACT_FILE=%HOME%\SemaphoreActions.jar
set ACT1_CLS=com\epam\mentoring\lessone\action
set ACT2_CLS=com\epam\mentoring\lessone\classloader

dir src\%PACKAGE%*.java /B/S > javasrc.tmp~
if ERRORLEVEL 1 (
echo Cannot find Java source files in src\..
goto abort
)
if exist tmp rmdir /S /Q tmp
mkdir tmp

@"%JAVA_HOME%\bin\javac.exe" -g -Xlint:none -d tmp @javasrc.tmp~

cd tmp

del %APP_FILE% 
jar cf %APP_FILE% %APP_CLS%

del %LOG_FILE% 
jar cf %LOG_FILE% %LOG1_CLS%
jar uf %LOG_FILE% %LOG2_CLS%

del %SEM_FILE% 
jar cf %SEM_FILE% %SEM_CLS%

del %ACT_FILE% 
jar cf %ACT_FILE% %ACT1_CLS%
jar uf %ACT_FILE% %ACT2_CLS%
                           
cd ..
echo Build done.
:abort
rmdir /S /Q tmp
del javasrc.tmp~
del exclude.tmp~
