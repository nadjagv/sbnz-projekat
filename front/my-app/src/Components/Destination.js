import React from "react";
import {
  Modal,
  Box,
  Typography,
  Stack,
  Card,
  CardHeader,
  IconButton,
  CardMedia,
  CardContent,
  CardActions,
  Collapse,
  Rating,
} from "@mui/material";
import { red } from "@mui/material/colors";
import FavoriteIcon from "@mui/icons-material/Favorite";
import ShareIcon from "@mui/icons-material/Share";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import CheckIcon from "@mui/icons-material/Check";
import CloseIcon from "@mui/icons-material/Close";
import { styled } from "@mui/material/styles";

export default function Destination({ destination,dblClick }) {

  const handleDblClick=()=>{
    dblClick(destination.id)
  }

  return (
    <Card
      sx={{ maxWidth: 345, margin: 10 }}
      style={{ border: "1px solid grey",margin:"auto" }}
      onDoubleClick={()=>{
        handleDblClick()
      }}
    >
      <CardHeader title={destination.location} subheader={destination.destinationType+", "+destination.proximity+", "+destination.price}/>
      <CardMedia component="img" height="194" image="" alt="Missing..." />
      <CardContent>
        <Typography variant="body1">
          Airport:
          {destination.airport ? (
            <CheckIcon></CheckIcon>
          ) : (
            <CloseIcon></CloseIcon>
          )}
        </Typography>
        <Typography variant="body1">
          Child activities:
          {destination.childActivities ? (
            <CheckIcon></CheckIcon>
          ) : (
            <CloseIcon></CloseIcon>
          )}
        </Typography>
        <Typography variant="body1">
          Beach:
          {destination.beach ? (
            <CheckIcon></CheckIcon>
          ) : (
            <CloseIcon></CloseIcon>
          )}
        </Typography>
        <Typography variant="body1">
          Rent a Car:
          {destination.rentACar ? (
            <CheckIcon></CheckIcon>
          ) : (
            <CloseIcon></CloseIcon>
          )}
        </Typography>
        <Typography variant="body1">
          Restaurants:
          {destination.restaurants ? (
            <CheckIcon></CheckIcon>
          ) : (
            <CloseIcon></CloseIcon>
          )}
        </Typography>
        <Typography variant="body1">
          Shops:
          {destination.shops ? (
            <CheckIcon></CheckIcon>
          ) : (
            <CloseIcon></CloseIcon>
          )}
        </Typography>
        <Typography variant="body1">
          Sightseeings:
          {destination.sightseeings ? (
            <CheckIcon></CheckIcon>
          ) : (
            <CloseIcon></CloseIcon>
          )}
        </Typography>
      </CardContent>
    </Card>
  );
}
