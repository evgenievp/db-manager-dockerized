package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/JPARelations";
    private static final String USER = "evgenievp";
    private static final String PASSWORD = "123456";

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();

        String sql = "SELECT id, name, position FROM player";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Player p = new Player(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("position")
                );
                players.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return players;
    }
    public void removePlayer(long id) {
        String sql = "DELETE FROM player WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Player with ID " + id + " was removed.");
            } else {
                System.out.println("No player found with ID " + id + ".");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void addPlayer(String name, String position) {
        String sql = "INSERT INTO player (name, position, team_id) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, position);
            stmt.setLong(3, 1);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println(" Player added successfully.");
            } else {
                System.out.println(" Player not added.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
