import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.apache.poi.sl.draw.geom.MoveToCommand as MoveToCommand
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.remote.server.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

String sNavigation = Navigation //'Masters;Receivables;TeleCaller'

String[] Nav = sNavigation.split(';')

println(Nav.size())

for (def index : (0..Nav.size() - 1)) {
    WebUI.delay(5)

    GlobalVariable.SAttributetext = (Nav[index])

    GlobalVariable.SAttributetitle = (Nav[index])

    println(GlobalVariable.SAttributetext)

    println(GlobalVariable.SAttributetitle)

    previousIndex = (index - 1)

    println(Nav[index])

    println(Nav[previousIndex])

    if ((Nav[index]) == (Nav[previousIndex])) {
        println(Nav[index])

        println(Nav[(index - 1)])

        List<WebElement> NavLinks = WebUiCommonHelper.findWebElements(findTestObject('Web Navigation_DatePick/Navigation/a_NavigationLink'), 
            5)

        // def NavaigationLink = NavLinks[1]
        println(NavLinks.size())

        findTestObject('Web Navigation_DatePick/Navigation/a_NavigationLink')

        if (NavLinks.size() > 0) {
            GlobalVariable.SAttributetext = 'Collection Accept (Mobile)'

            GlobalVariable.SAttributetitle = 'Collection Accept (Mobile)'

//            WebUI.scrollToElement(findTestObject('Web Navigation_DatePick/Navigation/a_NavigationLink'), 0)

            WebElement NavLink = NavLinks[1]

            NavLink.click()
        }
    }
    
    if ((Nav[index]) == 'Receivables') {
        WebUI.click(findTestObject('Web Navigation_DatePick/Navigation/a_Receivables'))
    } else if ((Nav[index]) != (Nav[previousIndex])) {
        WebUI.click(findTestObject('Web Navigation_DatePick/Navigation/a_NavigationLink'))
    }
}
