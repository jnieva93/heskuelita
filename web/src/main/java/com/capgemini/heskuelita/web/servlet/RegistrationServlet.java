package com.capgemini.heskuelita.web.servlet;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;


import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {

    private BasicDataSource dataSource;

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Crea un nuevo Datasource
        this.dataSource = new BasicDataSource();

        // Los primeros setean url, usuario y contrasena de postgres. Los
        // otros tres por ahora por defecto asi
        dataSource.setUrl("jdbc:postgresql://localhost:5432/heskuelita");
        dataSource.setUsername("postgres");
        dataSource.setPassword("mhfu17");
        dataSource.setMinIdle (5);
        dataSource.setMaxIdle (10);
        dataSource.setMaxOpenPreparedStatements (100);
        dataSource.setDriverClassName("org.postgresql.Driver");

        // Obtenemos los datos del formulario
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String dni = request.getParameter("dni");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try {
            // Datos a la tabla student
            PreparedStatement prepStm = this.dataSource.getConnection().prepareStatement("INSERT INTO student VALUES (default, ?, ?, ?, ?, ?, ?, ?)");

            prepStm.setString(1, name);
            prepStm.setString(2, lastName);
            prepStm.setString(3, dni);
            prepStm.setString(4, phone);
            prepStm.setString(5, address);
            prepStm.setString(6, gender);
            prepStm.setString(7, userName);

            // Ejecuta el insert
            prepStm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Datasource 2
        try {
            // Datos a la tabla users
            PreparedStatement prepStm = this.dataSource.getConnection().prepareStatement("INSERT INTO users VALUES (?, ?, ?)");

            prepStm.setString(1, userName);
            prepStm.setString(2, password);
            prepStm.setString(3, email);

            // Ejecuta el insert
            prepStm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect ("index.jsp");
    }

}
