import java.util.Hashtable;

/* the Library class */
public class Library extends Building{

  private Hashtable<String, Boolean> collection;

  /* Constructor */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    collection = new Hashtable<String, Boolean>();
  }

  /* Constructor that just takes the name */
  public Library(String name){
    super(name, "<address unknown>", 1);
  }

  /* Constructor that takes no parameters */
  public Library(){
    super("<name unknown>","<address unknown>", 1);
  }

  /* Adds a book to the collection 
   * @param title the book to be added
  */
  public void addTitle(String title){
    collection.put(title,true);
  }

  /* removes a book from the collection
   * @param title the book to be removed
   * @return String the title that has been removed
   */
  public String removeTitle(String title){
    collection.remove(title);
    return title;
  }

  /* checks out a book from the library, changes the book's status to not available
   * @param title the book to be removed
   */
  public void checkOut(String title){
    if (collection.containsKey(title)){
      collection.replace(title,false);
    }
  }

  /* returns a book from the library, changes the book's status to available
   * @param title the book to be returned
   */
  public void returnBook(String title){
    if (collection.containsKey(title)){
      collection.replace(title,true);
    }
  }
  
  /* tells the user whether the given book is in the collection
   * @param title the title of the book in question
   * @return boolean returns true if the book is in the collection
   */
  public boolean containsTitle(String title){
    return collection.containsKey(title);
  }

  /* tells the user whether the given book is available
   * @param title the title of the book in question
   * @return boolean returns true if the book is in the collection
   */
  public boolean isAvailable(String title){
    return collection.get(title);
  }

  // used https://www.programiz.com/java-programming/library/hashmap/foreach for an example on how to use the forEach() method
  /* prints out the entire collection in an easy-to-read way (including checkout status) */
  public void printCollection(){
    System.out.println("Printing this library's collection...");
    collection.forEach((key, value) -> {
      System.out.print(key);
      if (value == true){
        System.out.println(" is available.");
      }
      else {
        System.out.println(" is not available.");
      }
    });
  }

  public void showOptions() {
    super.showOptions();
    System.out.println(" + checkOut(title) \n + returnBook(title)");
  }
  
  public static void main(String[] args) {
    Library myLib = new Library("Neilson", "1 Green Street", 4);
    myLib.addTitle("The Lorax by Dr. Seuss");
    myLib.addTitle("Harry Potter by JK Rowling");
    myLib.checkOut("Harry Potter by JK Rowling");
    myLib.checkOut("The Lorax by Dr. Seuss");
    myLib.returnBook("The Lorax by Dr. Seuss");
    System.out.println(myLib.containsTitle("The Lorax by Dr. Seuss"));
    System.out.println(myLib.isAvailable("The Lorax by Dr. Seuss"));
    myLib.printCollection();
    myLib.showOptions();
  }
}