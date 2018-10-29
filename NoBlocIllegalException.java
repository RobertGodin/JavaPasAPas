
class NoBlocIllegalException extends Exception{
  public NoBlocIllegalException(int noBloc){
    super("Num�ro de bloc ill�gal :"+noBloc);
  }
}