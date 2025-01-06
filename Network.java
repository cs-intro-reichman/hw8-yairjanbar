/** Represents a social network. The network has users, who follow other uesrs.
 *  Each user is an instance of the User class. */
public class Network {

    // Fields
    private User[] users;  // the users in this network (an array of User objects)
    private int userCount; // actual number of users in this network

    /** Creates a network with a given maximum number of users. */
    public Network(int maxUserCount) {
        this.users = new User[maxUserCount];
        this.userCount = 0;
    }

    /** Creates a network  with some users. The only purpose of this constructor is 
     *  to allow testing the toString and getUser methods, before implementing other methods. */
    public Network(int maxUserCount, boolean gettingStarted) {
        this(maxUserCount);
        users[0] = new User("Foo");
        users[1] = new User("Bar");
        users[2] = new User("Baz");
        userCount = 3;
    }

    public int getUserCount() {
        return this.userCount;
    }
    /** Finds in this network, and returns, the user that has the given name.
     *  If there is no such user, returns null.
     *  Notice that the method receives a String, and returns a User object. */
    public User getUser(String name) {
        //// Replace the following statement with your code
        char firstL = name.charAt(0);
        if (firstL >= 'a' && firstL <= 'z') {
            firstL = (char) (firstL - 32);
        }
        String newName = firstL + name.substring(1);
        for (int i=0;i<userCount;i++) {
            if (users[i].getName().equals(newName)) {
                return users[i];
            }
        }
        return null;
    }

    /** Adds a new user with the given name to this network.
    *  If ths network is full, does nothing and returns false;
    *  If the given name is already a user in this network, does nothing and returns false;
    *  Otherwise, creates a new user with the given name, adds the user to this network, and returns true. */
    public boolean addUser(String name) {
        //// Replace the following statement with your code
        if (name == null) {
            return false;
        }
        char firstL = name.charAt(0);
        if (firstL >= 'a' && firstL <= 'z') {
            firstL = (char) (firstL - 32);
        }
        String newName = firstL + name.substring(1);
        if (userCount == users.length) {
            return false;
        }
        for (int i=0;i<userCount;i++) {
            if (users[i].getName().equals(newName)) {
                return false;
            }
        }
        users[userCount] = new User(newName);
        userCount++;
        return true;
    }

    /** Makes the user with name1 follow the user with name2. If successful, returns true.
     *  If any of the two names is not a user in this network,
     *  or if the "follows" addition failed for some reason, returns false. */
    public boolean addFollowee(String name1, String name2) {
        //// Replace the following statement with your code
        if (name1 == null || name2 == null) {
            return false;
        }
        char firstL1 = name1.charAt(0);
        if (firstL1 >= 'a' && firstL1 <= 'z') {
            firstL1 = (char) (firstL1 - 32);
        }
        String newName1 = firstL1 + name1.substring(1);
        char firstL2 = name2.charAt(0);
        if (firstL2 >= 'a' && firstL2 <= 'z') {
            firstL2 = (char) (firstL2 - 32);
        }
        String newName2 = firstL2 + name2.substring(1);
        boolean isInNet1 = false, isInNet2= false;
        for (int i=0;i<userCount;i++) {
            if (users[i].getName().equals(newName1)) {
                isInNet1=true;
            }
            if (users[i].getName().equals(newName2)) {
                isInNet2=true;
            }
        }
        if (isInNet1 == false || isInNet2 == false) return false;
        User user1 = getUser(newName1);
        User user2 = getUser(newName2);
        if (user1!=null && user2!=null) {
            user1.addFollowee(newName2);
        }
        return false;
    }
    
    /** For the user with the given name, recommends another user to follow. The recommended user is
     *  the user that has the maximal mutual number of followees as the user with the given name. */
    public String recommendWhoToFollow(String name) {
        //// Replace the following statement with your code
        User mostRecommendedUserToFollow = null;
        User currentUser = getUser(name);
        int recommemd = 0;
        for (int i=0;i<userCount;i++) {
            if(users[i].equals(currentUser)) {
                continue;
            }
            int mutualFrineds = currentUser.countMutual(users[i]);
            if (recommemd < mutualFrineds) {
                recommemd = mutualFrineds;
                mostRecommendedUserToFollow = users[i];
            }
        }
        if (mostRecommendedUserToFollow != null) {
            return mostRecommendedUserToFollow.getName();
        }
        return null;
    }

    /** Computes and returns the name of the most popular user in this network: 
     *  The user who appears the most in the follow lists of all the users. */
    public String mostPopularUser() {
        //// Replace the following statement with your code
        return null;
    }

    /** Returns the number of times that the given name appears in the follows lists of all
     *  the users in this network. Note: A name can appear 0 or 1 times in each list. */
    private int followeeCount(String name) {
        //// Replace the following statement with your code
        return 0;
    }

    // Returns a textual description of all the users in this network, and who they follow.
    public String toString() {
       //// Replace the following statement with your code
       String result = "Network:\n";
       for (int i=0; i<userCount;i++) {
            result = result + users[i].toString() + " ->\n";
       }
       return result;
    }
}
