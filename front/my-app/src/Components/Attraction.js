import React from "react";
import {
  Typography,
  Card,
  CardHeader,
  IconButton,
  CardMedia,
  CardContent,
  CardActions,
  Collapse,
  Rating,
} from "@mui/material";
import CheckIcon from "@mui/icons-material/Check";
import CloseIcon from "@mui/icons-material/Close";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import { useState } from "react";
import { styled } from "@mui/material/styles";

const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme, expand }) => ({
  transform: !expand ? "rotate(0deg)" : "rotate(180deg)",
  marginLeft: "auto",
  transition: theme.transitions.create("transform", {
    duration: theme.transitions.duration.shortest,
  }),
}));

export default function Attraction({ attr,onDelete }) {
  const [expanded, setExpanded] = useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };
  return (
    <Card
      sx={{ maxWidth: 345, margin: 10 }}
      style={{ border: "1px solid grey", margin: "auto", marginTop: "10px" }}
    >
      <CardHeader title={attr.name} subheader={attr.attractionType}/>
      <CardMedia component="img" height="194" image="" alt="Missing..." />
      <CardContent>
        <Typography variant="body1">
          Tickets:
          {attr.tickets ? <CheckIcon></CheckIcon> : <CloseIcon></CloseIcon>}
        </Typography>
        <Typography variant="body1">
          Child friendly:
          {attr.childFriendly ? (
            <CheckIcon></CheckIcon>
          ) : (
            <CloseIcon></CloseIcon>
          )}
        </Typography>
        <Typography variant="body1">
          Close to town:
          {attr.nearDestination ? (
            <CheckIcon></CheckIcon>
          ) : (
            <CloseIcon></CloseIcon>
          )}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          {attr.description}
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        {onDelete && (
          <IconButton
            aria-label="close"
            onClick={() => {
              onDelete(attr.id);
            }}
          >
            <CloseIcon />
          </IconButton>
        )}
        <ExpandMore
          expand={expanded}
          onClick={handleExpandClick}
          aria-expanded={expanded}
          aria-label="show more"
        >
          <ExpandMoreIcon />
        </ExpandMore>
      </CardActions>
      <Collapse in={expanded} timeout="auto" unmountOnExit>
        <CardContent>
          <Typography paragraph>Review:</Typography>
          {attr.reviews.map((rev) => (
            <div>
              <Typography component="legend">{rev.date}</Typography>
              <Rating name="read-only" value={rev.rating} readOnly />
            </div>
          ))}
        </CardContent>
      </Collapse>
    </Card>
  );
}
