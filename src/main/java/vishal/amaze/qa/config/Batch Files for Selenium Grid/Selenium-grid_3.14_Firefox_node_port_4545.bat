Echo off
Title Firefox Node on 4545

Echo Setting Project Location for ChromeDriver Node
set projectLocation="C:\Selenium Grid
pushd %projectLocation%

Echo Setting Chromedriver path and creating node on 4545
java -Dwebdriver.gecko.driver="C:\Selenium Grid Drivers\geckodriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.1.11:4444/grid/register -port 4545
pause