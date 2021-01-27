package usantatecla.utils;

interface Coordinate {
  
  static Coordinate NULL = NullCoordinate.getInstance();
  boolean isNull();
  Direction getDirection(Coordinate coordinate);
  boolean inHorizontal(Coordinate coordinate);
  boolean inVertical(Coordinate coordinate);
  boolean inMainDiagonal();

}
