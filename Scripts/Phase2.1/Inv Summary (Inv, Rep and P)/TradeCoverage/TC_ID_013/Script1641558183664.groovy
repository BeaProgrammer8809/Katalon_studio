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
import java.time.LocalDate as LocalDate

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyInvoice_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 16)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyReplacement_Quantity'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyProduct_Buying_Quantity'), [('testData1') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 16)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        'ProductName', 16), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), findTestData(
        'Phase2.1/TY_05/Testdata').getValue('Data1', 28))

def PiecesInSummary = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

def UnitPriceInSummary = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

def PiecesAndUnitPrice = Double.parseDouble(PiecesInSummary) * Double.parseDouble(UnitPriceInSummary)

def MultiplyOfPiecesAndUnitprice = PiecesAndUnitPrice.toString()

def TotalPriceInSummary = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

double TotalPrice = Double.parseDouble(TotalPriceInSummary)

boolean Value = MultiplyOfPiecesAndUnitprice.contains(TotalPriceInSummary)

def Taxvalue = Value.toString()

Mobile.verifyMatch(Taxvalue, findTestData('Phase2.1/TY_05/Testdata').getValue('Data2', 25), false, FailureHandling.OPTIONAL)

/*Verification done to check the tax is added (If Total amount value is greater than Total sku amount then the tax is added )*/
def ValueAmount = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

double ValueAmt = Double.parseDouble(ValueAmount)

'Calculation Value'
def IEPSTaxText = findTestData('Phase2.1/TY_05/Testdata').getValue(6, 1)

double IEPSTax = Double.parseDouble(IEPSTaxText)

//def IVATaxText = findTestData('Phase2.1/CommonData/CommonData').getValue('IVA-16', 1)
//double IVATax = Double.parseDouble(IVATaxText)
double skuTotal = TotalPrice + (TotalPrice * (IEPSTax / 100))

//GlobalVariable.Result=skuTotal.round()
Mobile.verifyEqual(skuTotal, ValueAmt, FailureHandling.OPTIONAL)

Mobile.verifyGreaterThan(ValueAmount, TotalPriceInSummary, FailureHandling.OPTIONAL)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_013'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
