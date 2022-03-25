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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2.1/TY_11/TestData').getValue(3, 56)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.waitForElementPresent(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 5)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def orderQuantity = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

def ProductBuyingQuantity1 = Integer.parseInt(orderQuantity) - 1

def ProductBuyingQuantity = ProductBuyingQuantity1.toString()

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Select_Reason_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.setText(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), ProductBuyingQuantity, 0)

def ExpectedSalesReturn = Mobile.getText(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 
    0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox'), 
    0)

def InvAmount1 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

double InvAmount = Double.parseDouble(InvAmount1)

println(InvAmount)

Mobile.clearText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 
    0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)

Mobile.clearText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 
    0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 10)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

'pesito amount before pressing cancel button on alert popup'

def PesitoAmount1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'),
	0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Back_Button'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/DeletePaymentPopup_Title/Cancel_ButtonDeletePaymentPopup'), 0)

'pesito amount after pressing cancel button on alert popup'

def PesitoAmount2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'),
	0)

'veryfying collection title is present after pressing cancel button on alert popup'

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), 0)

'verifying both pesito amount before and after pressing cancel button is same'

Mobile.verifyEqual(PesitoAmount1, PesitoAmount2, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/ScreenShot'), [('testCaseName') : 'TC_ID_459'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
