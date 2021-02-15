class NoBlocIllegalException extends Exception {
  public NoBlocIllegalException(int noBloc) {
    super("Numéro de bloc illégal :" + noBloc);
  }
}
