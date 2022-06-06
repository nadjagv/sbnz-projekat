import React, { useState, useEffect } from "react";
import { NavLink } from "react-router-dom";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import { Link } from "react-router-dom";
import axios from "axios";
import environment from "../Constants/Environment";

function Header(props) {
  const handleLogout = () => {};
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
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
        </Toolbar>
      </AppBar>
    </Box>
  );
}
export default Header;
