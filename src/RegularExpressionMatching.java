public class RegularExpressionMatching {
    /*
       CASE 1 : length 0 regular expression
       Case 2:  A regular expression starting with $ or ending with ^
       Case 3 : A regular expression starting with a * match, eg, a*wXY or *Wa
       Case 4  : A regular expression matching with alphanumeric character or dot
       Note : here * means repetition of previous character
     */

    boolean isMatch (String regex,  String text)
    {
        if (regex.charAt(0) =='^')
        {
          isMatchHere(regex, 1, text, 0);
        }
        for (int i = 0; i<= text.length(); i++)
        {
            if (isMatchHere(regex, 0, text, i))
            {
                return true;
            }
        }
        return false;
    }

    boolean isMatchHere (String regex, int regexOffset, String text, int textOffset)
    {
        if (regexOffset == regex.length())
        {
            return true;
        }
        if (regexOffset == regex.length() -1 && regex.charAt(regexOffset) =='$')
        {
            return textOffset == text.length();
        }
        if (regex.length() - regexOffset >=2 && regex.charAt(regexOffset + 1) == '*')
        {
            for (int i = textOffset + 1; i < text.length() &&
             regex.charAt(regexOffset)=='.' || regex.charAt(regexOffset) ==text.charAt(i-1);
                 i++ )
            {
                if (isMatchHere(regex, regexOffset +2, text, i))
                {
                    return true;
                }
            }
            return isMatchHere(regex, regexOffset+2, text, textOffset);
        }
        return textOffset < text.length() &&
                regex.charAt(regexOffset) == '.'  || regex.charAt(regexOffset) ==text.charAt(textOffset)
                && isMatchHere(regex, regexOffset +1, text, textOffset+1);
    }
}
