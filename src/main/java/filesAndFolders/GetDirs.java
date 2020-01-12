package filesAndFolders;

public class GetDirs {

    public static String getDiscordCachePath() {
        return System.getProperty("user.home") + "\\AppData\\Roaming\\Discord\\Cache";
    }
}
