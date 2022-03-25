import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStarFilterOrderAndInvoiceScreen01/All_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
		2, 11), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
		3, 11), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)



Mobile.tap(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)


Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)


def sizeNum = findTestData('Phase2/TY_05/Applying_Scheme').getValue(8, 11)

Integer size = ((sizeNum) as Integer)

Mobile.delay(8)

for (int i = 0; i < size; i++) {
	Mobile.tap(findTestObject('Object Repository/Phase2/BINumberPad/Back_Space'), 0)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)



GlobalVariable.DropdownName= findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 1)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('Bank', 4)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)



GlobalVariable.DropdownName= findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 2)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('Branch', 4)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('Bank', 4)

 
Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(4, 11))

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('Branch', 4)


Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'),
	findTestData('Phase2/TY_05/Applying_Scheme').getValue(5, 11), FailureHandling.STOP_ON_FAILURE)


Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/Collection/Screenshot'), [('testCaseName') : 'TC_232'], FailureHandling.STOP_ON_FAILURE)
println('Select Branch should be displayed after choosing any bank from Select Bank field')

Mobile.closeApplication()
