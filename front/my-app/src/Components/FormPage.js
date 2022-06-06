import React from "react";
import {
  Grid,
  Paper,
  TextField,
  Button,
  FormControlLabel,
  FormLabel,
  Select,
  MenuItem,
  InputLabel,
  Checkbox,
  Autocomplete,
} from "@mui/material";
import axios from "axios";
import { useState, useEffect } from "react";
import environment from "../Constants/Environment";
import { useNavigate,Navigate } from "react-router-dom";
import { RadioGroup, Radio } from "@mui/material";
import Attractions from "./Attractions";
import Header from './Header'

export default function FormPage() {
  const [transport, setTransport] = useState("PLANE");
  const [children, setChildren] = useState(false);
  const [budget, setBudget] = useState(0.0);
  const [age, setAge] = useState(0);
  const [partner, setPartner] = useState("ALONE");
  const [interests, setInterests] = useState([]);

  const navigate = useNavigate();

  const options = [
    { value: "BEACH", name: "Beach" },
    { value: "SHOPPING", name: "Shopping" },
    { value: "SIGHTSEEING", name: "Sightseeing" },
    { value: "NIGHTLIFE", name: "Nightlife" },
    { value: "ADVENTURE", name: "Adventure" },
    { value: "FOOD", name: "Food" },
  ];

  useEffect(() => {}, []);

  const handleSearch = () => {
    const interestsDTO=interests.map(i=>i.value)
    axios.post(environment.baseURL+'destination',{transportation:transport,budget:budget,age:age,travelCompanion: partner,children:children,interests:interestsDTO}).then(response=>{
        console.log(response.data)
        navigate('/destinations',{state:{destinations:response.data,parameters:{transportation:transport,budget:budget,age:age,travelCompanion: partner,children:children,interests:interestsDTO}}});
    });
  };

  const paperStyle = {
    padding: 20,
    height: "80vh",
    width: 280,
    margin: "20px auto",
  };
  const btnstyle = { margin: "8px 0" };
  return (
    <><Header></Header>
    <Grid>
      <Paper elevation={10} style={paperStyle}>
        <Grid>
          <h2>Fill the form</h2>
        </Grid>{" "}
        <FormLabel id="demo-row-radio-buttons-group-label">Transport</FormLabel>
        <RadioGroup
          aria-labelledby="demo-radio-buttons-group-label"
          name="radio-buttons-group"
          value={transport}
          onChange={(e) => {
            setTransport(e.target.value);
          }}
          row
        >
          <FormControlLabel value="PLANE" control={<Radio />} label="Plane" />
          <FormControlLabel value="BUS" control={<Radio />} label="Bus" />
          <FormControlLabel value="CAR" control={<Radio />} label="Car" />
        </RadioGroup>
        <FormLabel id="demo-row-radio-buttons-group-label">Children</FormLabel>
        <RadioGroup
          aria-labelledby="demo-radio-buttons-group-label"
          name="radio-buttons-group"
          value={children}
          onChange={(e) => {
            setChildren(e.target.value);
          }}
          row
        >
          <FormControlLabel value={false} control={<Radio />} label="No" />
          <FormControlLabel value={true} control={<Radio />} label="Yes" />
        </RadioGroup>
        <InputLabel id="demo-simple-select-label">Travelling with</InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={partner}
          label="Travelling with"
          onChange={(e) => {
            setPartner(e.target.value);
          }}
        >
          <MenuItem value="ALONE">Alone</MenuItem>
          <MenuItem value="FAMILY">Family</MenuItem>
          <MenuItem value="FRIENDS">Friends</MenuItem>
          <MenuItem value="PARTNER">Partner</MenuItem>
        </Select>
        <Autocomplete
          multiple
          id="checkboxes-tags-objects"
          value={interests}
          options={options.map((o) => o)}
          isOptionEqualToValue={(option, value) => option.value === value.value}
          disableCloseOnSelect
          onChange={(e, newValue) => {
            setInterests(newValue);
          }}
          getOptionLabel={(option) => option.name}
          renderOption={(props, option, { selected }) => (
            <li {...props}>
              <Checkbox style={{ marginRight: 8 }} checked={selected} />
              {option.name}
            </li>
          )}
          style={{ width: 260 }}
          renderInput={(params) => (
            <TextField {...params} label="Interests" placeholder="Interests" />
          )}
        />
        <TextField
          margin="normal"
          label="Budget"
          type="number"
          placeholder="Enter budget"
          fullWidth
          required
          onChange={(e) => {
            setBudget(e.target.value);
          }}
        ></TextField>
        <TextField
          margin="normal"
          label="Age"
          type="number"
          placeholder="Enter age"
          fullWidth
          required
          onChange={(e) => {
            setAge(e.target.value);
          }}
        ></TextField>
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
      </Paper>

    </Grid>
    </>
  );
}
