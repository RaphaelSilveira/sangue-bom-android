package br.com.bom.sangue.sangue_bom_android.Constants;

/**
 * Created by Raphael on 14/11/2016.
 */
public final class Endpoints {

    private static final String ENDPOINT = "http://192.168.0.15:8080";

    public static final String BLOOD_DONATOR_FIND_ONE_BY_CPF = ENDPOINT + "/blood-donator/find-by-cpf/";

    public static final String INTENT_DONATION_CREATE = ENDPOINT + "/intent-donation";
}
