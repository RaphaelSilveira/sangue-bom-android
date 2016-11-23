package br.com.bom.sangue.sangue_bom_android.Constants;

/**
 * Created by Raphael on 14/11/2016.
 */
public final class Endpoints {


    private static final String ENDPOINT = "http://192.168.0.15:8080";

    public static final String BLOOD_DONATOR_FIND_ONE_BY_CPF = ENDPOINT + "/blood-donator/find-by-cpf/";

    public static final String NEWS_CREATE = ENDPOINT + "/news";

    public static final String INTENT_DONATION_CREATE_DONATOR = ENDPOINT + "/intent-donation/create-donator";
    public static final String INTENT_DONATION_UPDATE_DONATOR = ENDPOINT + "/intent-donation/update-donator";
    public static final String INTENT_DONATION_FIND_ALL = ENDPOINT + "/intent-donation/find-all";

    public static final String RANKING_DONATION_GET = ENDPOINT + "/ranking-donations";

    public static final String LOGIN = ENDPOINT + "/administrator/login/";

    public static final String NEWS_LIST = ENDPOINT + "/news/list-all";
}
