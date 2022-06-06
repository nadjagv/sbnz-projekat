import React from "react";
import { Grid, Paper, TextField, Button } from "@mui/material";
import axios from "axios";
import { useState, useEffect } from "react";
import environment from "../Constants/Environment";
import { useNavigate } from "react-router-dom";
import AuthService from "../Services/AuthService";
import Header from './Header'

export default function LoginPage() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigation = useNavigate();


  useEffect(() => {
    if(AuthService.getUser()){
      AuthService.removeUser();
    }
  }, []);

  let loginDetails = {
    username: username,
    password: password,
  };
  const handleLogin = () => {
    axios.post(environment.baseURL+'auth/login',{username,password}).then(response=>{
      console.log(response)
      AuthService.setUser(response.data)
      navigation("/destinationsAdmin")
  });
  };

  const paperStyle = {
    padding: 20,
    height: "35vh",
    width: 280,
    margin: "20px auto",
  };
  const btnstyle = { margin: "8px 0" };
  return (
    <><Header></Header><Grid>
      <Paper elevation={10} style={paperStyle}>
        <Grid>
          <h2>Sign In</h2>
        </Grid>{" "}
        <TextField
          margin="normal"
          label="Username"
          placeholder="Enter username"
          fullWidth
          required
          onChange={(e) => {
            setUsername(e.target.value);
          }}
        ></TextField>
        <TextField
          margin="normal"
          label="Password"
          placeholder="Enter password"
          type="password"
          onChange={(e) => {
            setPassword(e.target.value);
          }}
          fullWidth
          required
        ></TextField>
        <Button
          type="submit"
          color="primary"
          variant="contained"
          style={btnstyle}
          fullWidth
          onClick={() => {
            handleLogin();
          }}
        >
          Sign in
        </Button>
      </Paper>
    </Grid></>
  );
}
