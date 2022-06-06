import React from "react";
import TextField from "@mui/material/TextField";
import { useState, useEffect } from "react";
import axios from "axios";
import environment from "../Constants/Environment";
import Destination from "./Destination";
import { Button } from "@mui/material";
import Header from './Header'

export default function Popular() {
  const [start, setStart] = useState("2022-01-01");
  const [end, setEnd] = useState("2022-01-01");
  const [destinations, setDestinations] = useState([]);
  const btnstyle = { margin: "8px 0", width: "30px" };

  const handleSearch = () => {
    axios
      .get(environment.baseURL + "query/popular?start="+start+"&end="+end)
      .then((response) => {
        console.log(response.data);
        setDestinations(response.data);
      });
  };
  return (
    <><Header></Header><div style={{margin:"20px"}}>
      <TextField
        id="date"
        label="Start"
        value={start}
        type="date"
        sx={{ width: 220 }}
        InputLabelProps={{
          shrink: true,
        }}
        onChange={(e) => {
          setStart(e.target.value);
        }}
      />
      <TextField
        id="date"
        style={{marginLeft:"10px"}}
        label="End"
        type="date"
        value={end}
        sx={{ width: 220 }}
        InputLabelProps={{
          shrink: true,
        }}
        onChange={(e) => {
          setEnd(e.target.value);
        }}
      />
      <div>
        <Button
          type="submit"
          color="primary"
          variant="contained"
          style={btnstyle}
          fullWidth
          onClick={() => {
            handleSearch();
          }}
        >
          Search
        </Button>
      </div>
      {destinations.map((dest) => (
        <Destination destination={dest}></Destination>
      ))}
    </div></>
  );
}
