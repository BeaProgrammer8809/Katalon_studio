import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 22), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyReplacement_Quantity'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyProduct_Buying_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 22)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.verifyElementText( findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), findTestData('Phase2.1/TY_05/Testdata').getValue('Data1', 28))

def InvoiceQuantityInSummary=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0)

def UnitPriceInSummary=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing') , 0)

def SkuTotalPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)

/*Verification done to check Comp Disc Value and Dist discount inside info popup Calculation*/

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC219'],
	FailureHandling.STOP_ON_FAILURE)

 def CompDiscValue = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'),
	0)
 
 CompDiscText = CompDiscValue.replace(' ', '')
 
 def CompoDiscountInsidePopup = CompDiscText.substring(1)

 def OrderedValueInsideInfoPopup = Mobile.getText( findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'), 0)
 
 def TotalAmountInsideInfoPopup = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Total_Value'), 0)

 def ActualDistDiscount = Mobile.getText( findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/DistDisc_Value'), 0)
 
  Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)
 
 def ItemdiscountinWeb = findTestData('Phase2.1/TY_05/Testdata').getValue('NOITEMDISC', 1)
 KeywordUtil.logInfo ("${ItemdiscountinWeb}")
 
 def categorydiscountinWeb = findTestData('Phase2.1/TY_05/Testdata').getValue('CATEGORYDISC', 1)
 KeywordUtil.logInfo ("${categorydiscountinWeb}")
 
 def TAX = findTestData('Phase2.1/TY_05/Testdata').getValue('IEPSTAX', 1)
 KeywordUtil.logInfo ("${TAX}")
 
 def GrossInvoice =  Double.parseDouble(InvoiceQuantityInSummary) * Double.parseDouble(UnitPriceInSummary)
 
 KeywordUtil.logInfo ("${GrossInvoice}")
 def SKUDiscount =  GrossInvoice * (Double.parseDouble(ItemdiscountinWeb)/100)
 
 KeywordUtil.logInfo ("${SKUDiscount}")
 def PriceafterItemDiscount = GrossInvoice - SKUDiscount
 
 KeywordUtil.logInfo ("${PriceafterItemDiscount}")
 def CategoryDiscount = PriceafterItemDiscount * (Double.parseDouble(categorydiscountinWeb)/100)
 
 KeywordUtil.logInfo ("${CategoryDiscount}")
 def PriceAfterAddingDiscount = PriceafterItemDiscount - CategoryDiscount
					 
 def compdiscount = SKUDiscount + CategoryDiscount

 def Discount = Math.round(compdiscount)
 
 int Calculatedcompdiscount  = (int)Discount
 
 def CalculatedCompDiscount = '-' + ' ' + Calculatedcompdiscount
 
 def GrossamountAfterAppliedDiscount = PriceAfterAddingDiscount
 KeywordUtil.logInfo ("${GrossamountAfterAppliedDiscount}")
 
 def TotalTaxAmount = GrossamountAfterAppliedDiscount * (Double.parseDouble(TAX)/100)
 KeywordUtil.logInfo ("${TotalTaxAmount}")
					    
 Mobile.verifyEqual(CompDiscValue, CalculatedCompDiscount,FailureHandling.STOP_ON_FAILURE)
 
 def ExpectedDistDiscount = findTestData('Phase2.1/TY_05/Testdata').getValue('DISTDISCOUNT', 1)
 
 Mobile.verifyMatch(ActualDistDiscount, ExpectedDistDiscount, false,FailureHandling.STOP_ON_FAILURE)
 
 Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC219'],
	FailureHandling.STOP_ON_FAILURE)

 Mobile.closeApplication()