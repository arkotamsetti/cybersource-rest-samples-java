package samples.tms.coreServices;

import java.util.Properties;

import com.cybersource.authsdk.core.MerchantConfig;

import Api.InstrumentIdentifierApi;
import Data.Configuration;
import Invokers.ApiClient;
import Invokers.ApiException;
import Model.TmsV1InstrumentidentifiersPost200Response;

public class RetrieveInstrumentIdentifier {
	private static String profileId = "93B32398-AD51-4CC2-A682-EA3E93614EB1";
	private static String tokenId = "7010000000004697654";
	private static String responseCode = null;
	private static String status = null;
	public static TmsV1InstrumentidentifiersPost200Response response;
	private static Properties merchantProp;
	
	public static void main(String args[]) throws Exception {
		process();
	}


	private static void process() throws Exception {

		try {
			/* Read Merchant details. */
			merchantProp = Configuration.getMerchantDetails();
			MerchantConfig merchantConfig = new MerchantConfig(merchantProp);
			
			InstrumentIdentifierApi instrumentIdentifierApi = new InstrumentIdentifierApi();
			response = instrumentIdentifierApi.tmsV1InstrumentidentifiersTokenIdGet(profileId,merchantConfig, tokenId);

			responseCode = ApiClient.responseCode;
			status = ApiClient.status;

			System.out.println("ResponseCode :" + responseCode);
			System.out.println("Status :" + status);
			System.out.println(response.getCard());
			

		} catch (ApiException e) {

			e.printStackTrace();
		}
	}

}
