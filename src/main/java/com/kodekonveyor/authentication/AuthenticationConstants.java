package com.kodekonveyor.authentication;

import java.util.regex.Pattern;

class AuthenticationConstants {

  final public static String NO_AUTHENTICATION = "No Authentication";
  final public static String NO_CREDENTIAL = "No Credential";

  final static public Pattern AUTH0_ID_EXTRACTION_PATTERN =
      Pattern.compile("github\\|(.*?)@.*");
}
