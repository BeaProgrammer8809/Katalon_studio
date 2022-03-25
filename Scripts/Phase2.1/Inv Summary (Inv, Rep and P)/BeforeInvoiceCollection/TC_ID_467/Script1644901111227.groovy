import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 19)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName,
	0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

def invamt=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 0)

def CashAmount=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println(invamt.length())

for (int i = 0; i < invamt.length(); i++) {
	
	Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)


for (int i = 0; i < invamt.length(); i++) {
	
	Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}

Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), findTestData('Phase2.1/TY_05/Collection').getValue(3, 11) , 0)


Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)


def CashPermission= Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)


for (int i = 0; i < invamt.length(); i++) {

Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}


Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)


def ChequePermission=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)



GlobalVariable.DropdownName= findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('Bank', 4)


Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.DropdownName= findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('Branch', 4)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

GlobalVariable.DropdownName= findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

GlobalVariable.DropdownOption= findTestData('Phase2.1/Common_Data/CommonData').getValue('ChequeType', 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), findTestData('Phase2.1/TY_05/Collection').getValue(3, 53), 0)

Mobile.verifyNotMatch(CashPermission, ChequePermission, false, FailureHandling.STOP_ON_FAILURE)



Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Submit_Button'), 0)


Mobile.delay(2)

AppiumDriver driver = MobileDriverFactory.getDriver()


def Actualtoastmessage = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println('Actualresult=' + Actualtoastmessage)

def Expectedtoastmessage = findTestData('Phase2.1/TY_05/Collection').getValue(3, 56)

println('Expectedresult=' + Expectedtoastmessage)

Mobile.verifyEqual(Actualtoastmessage, Expectedtoastmessage, FailureHandling.STOP_ON_FAILURE)

println(Actualtoastmessage)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/BeforeInvoiceCollection/Screenshot'), [('testCaseName') : 'TC_467_Collection'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()








