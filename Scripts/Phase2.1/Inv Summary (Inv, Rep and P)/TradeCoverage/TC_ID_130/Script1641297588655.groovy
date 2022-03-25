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
import org.openqa.selenium.WebElement as WebElement

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyInvoice_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 19)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyReplacement_Quantity'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

def InvoiceAmount = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

Integer length = InvoiceAmount.length()

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

for (int i = 0; i <= length; i++) {
	Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0, FailureHandling.OPTIONAL)
}

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

def ChequeAmount = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/Amount_EditText'),
	0)

double totalcheckamount = Double.parseDouble(ChequeAmount)

def TotalinvAmount=totalcheckamount.toString()

def checklength = ChequeAmount.length()

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/Amount_EditText'), 0)

for (int i = 0; i <= checklength; i++) {
	Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0, FailureHandling.OPTIONAL)
}

Mobile.setText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/Amount_EditText'), TotalinvAmount,
	0, FailureHandling.OPTIONAL)

Mobile.delay(2)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/SelectBank'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/SelectBranch'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/SelectChequeType'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), findTestData(
	'Phase2.1/TY_05/Testdata').getValue('Data1', 12), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Submit_Button'), 0)

/*Verification done to check the Preticket icon  is not visible after submitting the invoice amount in cheques mode*/

Mobile.verifyElementNotExist( findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/PrintPreticket_Icon'), 5 ,FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/Collection_Title'), 5)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_130'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

