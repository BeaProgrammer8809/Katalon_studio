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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Trade Coverage_Order and Invoice'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Delivery Summary_Edit'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Search icon'), 
    0)

not_run: Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    SKUName, 0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    '021_SD_MUMB_PRO', 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

txtSearchingProduct = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0)

println(txtSearchingProduct)

txtPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtPiecesValue)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

txtEnteredPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

println(txtEnteredPiecesValue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

txtAfterOkPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtAfterOkPiecesValue)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

txtTotalValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstSKU_Total'), 
    0)

println(txtTotalValue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

txtSRPValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

println(txtSRPValue)

txtAfterOkPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtAfterOkPiecesValue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/btn_Next'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_Invoice'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_OK'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_OK'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_ICS_OK'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_ICS_OK'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/btn_Create Ticket Invoice'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/btn_Create Ticket Invoice'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/PayMentCheckBox'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection_CloseIcon'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection_CloseIcon'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection_CloseIcon'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/txtView_Do you want to delete payment transaction'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/txtView_Do you want to delete payment transaction'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/txtView_Do you want to delete payment transaction'), 
    'Do you want to delete payment transaction?')

txtPopUpTitle = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/txtView_Do you want to delete payment transaction'), 
    0)

Mobile.verifyMatch('Do you want to delete payment transaction?', txtPopUpTitle, false)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/btn_Yes'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/btn_Yes'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/btn_Yes'), 
    'Yes')

btnYes = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/btn_Yes'), 
    0)

Mobile.verifyMatch('Yes', btnYes, false)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/btn_Cancel'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/btn_Cancel'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/btn_Cancel'), 
    'Cancel')

btnCancel = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/btn_Cancel'), 
    0)

Mobile.verifyMatch('Cancel', btnCancel, false)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'TC_ID_168'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/btn_Cancel'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection_CloseIcon'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/btn_Yes'), 
    0)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'TC_ID_170'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/PayMentCheckBox'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection_CloseIcon'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Collection PopUp/btn_Yes'), 
    0)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'TC_ID_169'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
