/* the Cafe class */
public class Cafe extends Building{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /* default constructor */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        nCoffeeOunces = 64;
        nSugarPackets = 100;
        nCreams = 100;
        nCups = 100;
    }

    /* constructor that takes a name and address and sets the number of floors to 1 */
    public Cafe(String name, String address){
        this(name, address, 1);
    }

    /*
     * sells a cup of coffee
     * @param size is the of cup being sold
     * @param nSugarPackets number of sugar packets used
     * @param nCreams number of creams used 
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (size > nCoffeeOunces){
            restock(64, 0 , 0, 0);
        }
        this.nCoffeeOunces -= size;

        if (nSugarPackets > this.nSugarPackets){
            restock(0,100,0,0);
        }
        this.nSugarPackets -= nSugarPackets;

        if (nCreams > this.nCreams){
            restock(0,0,100,0);
        }
        this.nCreams -= nCreams;

        if (nCups < 1){
            nCups += 100;
        }
        this.nCups--;
    }

    /*
     * sells a black coffee
     * @param size is the of cup being sold
     */
    public void sellCoffee(int size){
        if (size > nCoffeeOunces){
            restock(64,0,0,0);
        }
        this.nCoffeeOunces -= size;

        if (nCups < 1){
            nCups += 100;
        }
        this.nCups--;
    }

    /*
     * restocks the number of supplies of the cafe
     * @param nCoffeeOunces the number of ounces of coffee to be restocked
     * @param nSugarPackets the number of sugar packets to be restocked
     * @param nCreams the number of creams to be restocked
     * @param nCups the number of cups to be restocked
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(size, nSugarPackets, nCreams)");
    }
    
    public void goToFloor(int floorNum){
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        if (floorNum != 1){
            throw new RuntimeException(("Invalid floor number. This floor is for employees only."));
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    public static void main(String[] args) {
        Cafe c = new Cafe("Compass", "Smith", 2);
        c.sellCoffee(16, 40,2);
        System.out.println(c.nSugarPackets);
        c.sellCoffee(2,80,1);
        System.out.println(c.nSugarPackets);
        c.showOptions();
        c.enter();
    }
    
}
