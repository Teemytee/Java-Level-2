public interface Chat {
    void broadcastMessage(String message);
    boolean isNicknameOccupied(String nickname);
    void subscribe(ClientHandler client);
    void unsubscribe(ClientHandler client);
    AuthenticationService getAuthenticationService();
    void privateMessage(StringBuilder message, String nickname, String sender);
    void errorMessage(int errorNumber, String nickname);
}
