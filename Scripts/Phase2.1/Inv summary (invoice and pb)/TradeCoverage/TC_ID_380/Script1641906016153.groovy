import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 19)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_380'], FailureHandling.STOP_ON_FAILURE)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_380'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 19)

Mobile.setText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Non_Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

//def Actual_Sales_Return = Mobile.getText(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'),0)
//Mobile.getText(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'),0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_380'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/Collection_Title'), 0, FailureHandling.STOP_ON_FAILURE)

println('Collection title is exist')

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/InvAmt_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

println('InvAmt text with value is exist')

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/MinAmt_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

println('MinAmt text with value is exist')

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_380'], FailureHandling.STOP_ON_FAILURE)

println('By default Efectivo mode selected')

def Default_InvAmt = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'),
	0, FailureHandling.STOP_ON_FAILURE)

def Efectivo_Balance = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

def splitTotal = Efectivo_Balance.split(' ')

Efectivo_Balance = (splitTotal[4])

println(Efectivo_Balance)

def Efectivo_Amt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

def Efectivo_Total_Paid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 0)

def splitTotal1 = Efectivo_Total_Paid.split(' ')

Efectivo_Total_Paid = (splitTotal1[3])

println(Efectivo_Total_Paid)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)

def CreditNote_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BICreditNoteScreen01/Amount_EditText'),0)

def Total_Amt = Double.parseDouble(Efectivo_Amt) + Double.parseDouble(CreditNote_Amt)

Mobile.verifyEqual(Efectivo_Balance, Total_Amt, FailureHandling.STOP_ON_FAILURE)

println('Balance amount should display based on amount entered in Total paid field')

Mobile.verifyEqual(Efectivo_Total_Paid, Total_Amt, FailureHandling.STOP_ON_FAILURE)

println('Total paid should display the amount entered in Total paid field')

Mobile.verifyEqual(Default_InvAmt, Total_Amt, FailureHandling.STOP_ON_FAILURE)

println('Total paid field should be filled with the corresponding legal entity Invoice amount as default')

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/KeyPad_Complete_Frame'), 0, FailureHandling.STOP_ON_FAILURE)

println('Keypad is present, numbers and decimal is displayed')

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_380'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()