import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElemen

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStarFilterOrderAndInvoiceScreen01/All_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_07/Applying Scheme/Execute').getValue(
        2, 7), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_1'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

/*Capturing the net amount value in the invoice summary screen */
def NetAmountInInvSummaryScreen = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_Price_ValueView'), 
    0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

/*verifying the check mode selected*/ 
boolean Attributevalue = Mobile.getAttribute(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 
    'selected', 0)

Mobile.verifyEqual(Attributevalue, true)

def MinimumAmount = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/MinAmt_TextView'), 0)

/*verification is done to check Min. Amt should also display the Net amount (value) displayed in Summary screen*/
Mobile.verifyMatch(NetAmountInInvSummaryScreen, MinimumAmount, false)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/Collection/Screenshot'), [('testCaseName') : 'TC_225'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()