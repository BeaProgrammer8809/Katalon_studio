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
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/Trade coverage/ProductReturnActivity_Reusable'), 
    [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Unload_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIUnload/NonSalable/Non_Salable_Action_Bar'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BIUnload/NonSalable/Total_Piece_Indexing'), 0)

//def PiecesBeforeUpdate = Mobile.getText(findTestObject('Phase2/BIUnload/NonSalable/NoSalable_Stock_Popup/Pieces_Edit_Text_Indexing'),
//0)
Mobile.tap(findTestObject('Phase2/BIUnload/NonSalable/NoSalable_Stock_Popup/Pieces_Edit_Text_Indexing'), 0)

/*Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Num- 0'), 0)

Mobile.getText(findTestObject('Phase2/BINumberPad/Num- 0'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Num- 1'), 0)

Mobile.getText(findTestObject('Phase2/BINumberPad/Num- 1'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Num- 2'), 0)

Mobile.getText(findTestObject('Phase2/BINumberPad/Num- 2'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Num- 3'), 0)

Mobile.getText(findTestObject('Phase2/BINumberPad/Num- 3'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Num- 4'), 0)

Mobile.getText(findTestObject('Phase2/BINumberPad/Num- 4'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Num- 5'), 0)

Mobile.getText(findTestObject('Phase2/BINumberPad/Num- 5'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Num- 6'), 0)

Mobile.getText(findTestObject('Phase2/BINumberPad/Num- 6'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Num- 7'), 0)

Mobile.getText(findTestObject('Phase2/BINumberPad/Num- 7'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Num- 8'), 0)

Mobile.getText(findTestObject('Phase2/BINumberPad/Num- 8'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Num- 9'), 0)

Mobile.getText(findTestObject('Phase2/BINumberPad/Num- 9'), 0)*/

for(int i=0;i<=9;i++){
	Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
	GlobalVariable.Number=findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', i+1)
	Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Number'), 0)
	GlobalVariable.index=findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)
	def Pieces=Mobile.getText(findTestObject('Object Repository/Phase2/BIUnload/NonSalable/NoSalable_Stock_Popup/Pieces_Edit_Text_Indexing'), 0)
	
	Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/Trade coverage/Screenshot'), ["testCaseName":"TC_052($i+1)"], FailureHandling.STOP_ON_FAILURE)
	
}

//println(' 0-9 values are allowed to enter into Piece Field')

//Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/Trade coverage/Screenshot'), ["testCaseName":"TC_052_invoiceSummary"], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

