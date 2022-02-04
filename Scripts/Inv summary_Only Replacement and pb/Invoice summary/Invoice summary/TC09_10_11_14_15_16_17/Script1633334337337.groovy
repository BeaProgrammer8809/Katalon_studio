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

not_run: Mobile.startApplication(GlobalVariable.apk_File, false)

not_run: CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Inv summary_invoice and pb/Cash Retailer Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Store Activity Screen/Order and  Invoice'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search icon'), 0)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search Input Field'), findTestData(
        'Phase 1/Anen/Inv summary_invoice and pb/Sku List').getValue('sku_ only_tax_IEPS', 1))

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/1st Row Returns input'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/1'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/OK Button'), 0)

'Unit_price_Order&Invoice'
Unit_price = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/1st Row SRP Price Value'), 
    0)

println(Unit_price)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Next Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Summary Page Title'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Summary Page Title'), 0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Summary Page Title'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Summary Page Title'), 0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Summary Page Title'), 'Summary')

pageTitle = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Summary Page Title'), 0)

println(pageTitle)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource1/Van Seller/Wild Card Retailer Summary Screen/Sku Name 1st Row'), 
    findTestData('Phase 1/Anen/Inv summary_invoice and pb/Sku List').getValue('sku_ only_tax_IEPS', 1))

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource1/Van Seller/Wild Card Retailer Summary Screen/Pieces Value'), 
    '0')

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource1/Van Seller/Wild Card Retailer Summary Screen/U.Price Value'), 
    Unit_price)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Actual return Value 1st Row'), '1')

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Piece Value 1st row'), '0')

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Invoice Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Invoice Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Total Qty Title Bottom'), 0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Total Qty Title Bottom'), 0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView - Invoice No'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView - Invoice No'), 
    0)

Mobile.callTestCase(findTestCase('Inv summary_Only Replacement and pb/Invoice summary/Reusables/Screenshot'), [('testCaseName') : 'TC09_10_11_14_15_16_17'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
