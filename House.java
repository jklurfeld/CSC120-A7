import java.util.ArrayList;

/* the House class */
public class House extends Building{
  ArrayList<String> residents;
  boolean hasDiningRoom;
  boolean hasElevator;

  /* Constructor */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  /* Constructor that takes no parameters */
  public House(){
    this("<name unknown>", "<address unknown>", 1, false, false);
  }

  /* Constructor that just takes the name, number of floors and whether there is a dining room*/
  public House(String name, int nFloors, boolean hasDiningRoom){
    this(name, "<address unknown>", nFloors, hasDiningRoom, false);
  }

  /*
   * accessor for the hasDiningRoom attribute
   * @return boolean returns true if the house has a dining room
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  }

  /* Accessor for hasElevator
   * @return boolean telling the user whether the house has an elevator
   */
  public boolean hasElevator(){
    return hasElevator;
  }

  /*
   * returns the number of residents in the house
   * @return int number of residents in the house
   */
  public int nResidents(){
    return residents.size();
  }

  /*
   * adds a resident to the list of residents in the house
   * @param name of the resident to be moved in
   */
  public void moveIn(String name){
    residents.add(name);
  }

  /*
   * removes a resident from the list of residents in the house
   * @param name of the resident to be removed
   * @return name of the resident removed
   */
  public String moveOut(String name){
    residents.remove(name);
    return name;
  }

  /*
   * method that returns true if the given person is a resident of the house
   * @param name of the person to be checked
   * @return boolean returns true if the given person is a resident of the house
   */
  public boolean isResident(String person){
    return residents.contains(person);
  }

  public void showOptions() {
    super.showOptions();
    System.out.println(" + moveIn(name) \n + moveOut(name)");
  }

  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (Math.abs(floorNum - activeFloor) > 1){
      if (!hasElevator){
        throw new RuntimeException("You cannot transport up more than one flight of stairs at a time.");
      }
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  public static void main(String[] args) {
    House lamont = new House("Lamont", "17 Prospect Street", 4, true, true);
    System.out.println(lamont);
    lamont.showOptions();
  }
}