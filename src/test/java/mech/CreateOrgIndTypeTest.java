package mech;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateOrganizationsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.BaseClass;

public class CreateOrgIndTypeTest extends BaseClass {
	@Test(groups="SmokeTest")
	public void createOrgWithIndType() throws Throwable {
		
		
		//Get Randum No
		int randomNum = jLib.getRandomNumber();

		//Read data from XL
		String org = eLib.getDataFromExcel("Sheet1", 3, 1)+randomNum;
		String con = eLib.getDataFromExcel("Sheet1", 3, 2)+randomNum;
		String indus = eLib.getDataFromExcel("Sheet1", 3, 3);//industry
		String typ = eLib.getDataFromExcel("Sheet1", 3, 4);//type
		
	
		//Step 2: Click on organization Module
		HomePage hp =new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		
		//Step 3: Click on create Organization 
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		
		//Step 4: Enter org Details and save
		CreateOrganizationsPage cop =new CreateOrganizationsPage(driver);
		cop.createOrgWithIndustryAndType(org, indus, typ);
		
		/*//Verification for Industry
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String confrimation_msg = oip.fetchConfirmationMessage();
		//verify message 
		String verify = oip.fetchIndustryName();
		Assert.assertTrue(verify.contains(indus));

		String verify1 = oip.fetchTypeName();
		Assert.assertTrue(verify1.contains(typ));*/
		

	}

}


