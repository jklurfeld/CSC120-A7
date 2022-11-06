import java.util.ArrayList;

/* the House class */
public class House extends Building{
  ArrayList<String> residents;
  boolean hasDiningRoom;

  /* Constructor */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

  /* Constructor that takes no parameters */
  public House(){
    this("<name unknown>", "<address unknown>", 1, false);
  }

  /* Constructor that just takes */
  public House(String name, int nFloors, boolean hasDiningRoom){
    this(name, "<address unknown>", nFloors, hasDiningRoom);
  }

  /*
   * accessor for the hasDiningRoom attribute
   * @return boolean returns true if the house has a dining room
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
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

  public static void main(String[] args) {
    House lamont = new House("Lamont", "17 Prospect Street", 4, true);
    System.out.println(lamont);
    lamont.showOptions();
  }

}