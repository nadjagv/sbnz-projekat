import React from "react";
import Header from "./Header";
import { useState } from "react";
import axios from "axios";
import { TextField, Paper, Button } from "@mui/material";
import environment from "../Constants/Environment";

export default function ConfigPage() {
  const [adultAge, setAdultAge] = useState(25);
  const [oldAge, setOldAge] = useState(60);

  const [standardBudget, setStandardBudget] = useState(500);
  const [luxBudget, setLuxBudget] = useState(1500);

  const handleAge = () => {
    axios.post(environment.baseURL+'settings/age',{adultAgeMin: adultAge,oldAgeMin:oldAge}).then(response=>{
      alert("Success")
    })
  };

  const handleBudget = () => {
    axios.post(environment.baseURL+'settings/budget',{standardBudgetMin: standardBudget,luxBudgetMin:luxBudget}).then(response=>{
      alert("Success")
    })
  };

  const paperStyle = {
    padding: 20,
    height: "22vh",
    width: 280,
    margin: "20px auto",
  };
  const btnstyle = { margin: "8px 0" };
  return (
    <>
      <Header></Header>
      <Paper elevation={10} style={paperStyle}>
        <TextField
          margin="normal"
          label="Adult age minimum"
          placeholder="Enter adult age minimum"
          fullWidth
          required
          onChange={(e) => {
            setAdultAge(e.target.value);
          }}
        ></TextField>
        <TextField
          margin="normal"
          label="Old age minimum"
          placeholder="Enter old age minimum"
          fullWidth
          required
          onChange={(e) => {
            setOldAge(e.target.value);
          }}
        ></TextField>
        <Button
          type="submit"
          color="primary"
          variant="contained"
          style={btnstyle}
          fullWidth
          onClick={() => {
            handleAge();
          }}
        >
          Change config for age
        </Button>
      </Paper>
      <Paper elevation={10} style={paperStyle}>
        <TextField
          margin="normal"
          label="Standard budget minimum"
          placeholder="Enter Standard budget minimum"
          fullWidth
          required
          onChange={(e) => {
            setStandardBudget(e.target.value);
          }}
        ></TextField>
        <TextField
          margin="normal"
          label="Lux budget minimum"
          placeholder="Enter Lux budget minimum"
          fullWidth
          required
          onChange={(e) => {
            setLuxBudget(e.target.value);
          }}
        ></TextField>
        <Button
          type="submit"
          color="primary"
          variant="contained"
          style={btnstyle}
          fullWidth
          onClick={() => {
            handleBudget();
          }}
        >
          Change config for budget
        </Button>
      </Paper>
    </>
  );
}
