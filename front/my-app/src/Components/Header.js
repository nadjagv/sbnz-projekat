import React, { useState, useEffect } from "react";
import { NavLink } from "react-router-dom";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import { Link } from "react-router-dom";
import axios from "axios";
import environment from "../Constants/Environment";
import AuthService from "../Services/AuthService";

function Header(props) {
  const handleLogout = () => {
  };
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          {!AuthService.getUser() && (
            <>
              <Typography
                color="inherit"
                variant="h6"
                component="div"
                sx={{ flexGrow: 1 }}
              >
                <Link style={{ textDecoration: "none" }} to="/">
                  Form
                </Link>
              </Typography>
              <Typography
                color="inherit"
                variant="h6"
                component="div"
                sx={{ flexGrow: 1 }}
              >
                <Link style={{ textDecoration: "none" }} to="/popular">
                  Popular
                </Link>
              </Typography>
              <Typography
                color="inherit"
                variant="h6"
                component="div"
                sx={{ flexGrow: 1 }}
              >
                <Link style={{ textDecoration: "none" }} to="/type">
                  Search for type
                </Link>
              </Typography>
              <Typography
                color="inherit"
                variant="h6"
                component="div"
                sx={{ flexGrow: 1 }}
              >
                <Link style={{ textDecoration: "none" }} to="/login">
                  Login
                </Link>
              </Typography>
            </>
          )}
          {AuthService.getUser() && (
            <>
              <Typography
                color="inherit"
                variant="h6"
                component="div"
                sx={{ flexGrow: 1 }}
              >
                <Link
                  style={{ textDecoration: "none" }}
                  to="/destinationsAdmin"
                >
                  Destinations
                </Link>
              </Typography>
              <Typography
                color="inherit"
                variant="h6"
                component="div"
                sx={{ flexGrow: 1 }}
              >
                <Link style={{ textDecoration: "none" }} to="/attractionsAdmin">
                  Attractions
                </Link>
              </Typography>
              <Typography
                color="inherit"
                variant="h6"
                component="div"
                sx={{ flexGrow: 1 }}
              >
                <Link style={{ textDecoration: "none" }} to="/config">
                  Configuration
                </Link>
              </Typography>
              <Typography
                color="inherit"
                variant="h6"
                component="div"
                sx={{ flexGrow: 1 }}
              >
                <Link
                  style={{ textDecoration: "none" }}
                  to="/login"
                  onClick={handleLogout}
                >
                  Logout
                </Link>
              </Typography>
            </>
          )}
        </Toolbar>
      </AppBar>
    </Box>
  );
}
export default Header;
