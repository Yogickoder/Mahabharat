Echo off
Title Firefox Node on 4547

Echo Setting Project Location for ChromeDriver Node
set projectLocation="C:\Selenium Grid
pushd %projectLocation%

Echo Setting IEdriver path and creating node on 4547
java -Dwebdriver.ie.driver="C:\Selenium Grid Drivers\IEDriverServer64.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.1.11:4444/grid/register -port 4547
pause