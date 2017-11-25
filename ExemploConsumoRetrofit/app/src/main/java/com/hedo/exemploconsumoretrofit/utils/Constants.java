package com.hedo.exemploconsumoretrofit.utils;

/**
 * Criado por hedo.junior em 22/11/2017.
 */

public class Constants {
    private static final String API_KEY = "77cde810";
    public static final String OMDB_API_BASE_URL = "http://www.omdbapi.com";
    private static final String APPENDABLE_API_KEY = "/?apikey=" + API_KEY;
    private static final String APPENDABLE_DEFAULT_CONFIG = APPENDABLE_API_KEY + "&r=json&plot=short";
    public static final String OMDB_MOVIE_SEARCH = APPENDABLE_DEFAULT_CONFIG;
//    public static final String OMDB_MOVIE_BY_IMDB_CODE = APPENDABLE_DEFAULT_CONFIG;
    public static final String LOG = "IMDBEDO";
}
