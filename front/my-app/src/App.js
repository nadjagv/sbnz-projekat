import './App.css';
import {
  BrowserRouter as Router,
  Route,
  Routes,
} from "react-router-dom";
import FormPage from './Components/FormPage'
import LoginPage from './Components/LoginPage';
import Header from './Components/Header';
import Popular from './Components/Popular';
import ForType from './Components/ForType';
import Destinations from './Components/Destinations';

function App() {
  return (
    <Router>
      <Header></Header>
      <div className="App">
        <Routes>
          <Route exact path="/" element={<FormPage></FormPage>}></Route>
          <Route exact path="/login" element={<LoginPage></LoginPage>}></Route>
          <Route exact path="/popular" element={<Popular></Popular>}></Route>
          <Route exact path="/type" element={<ForType></ForType>}></Route>
          <Route exact path="/destinations" element={<Destinations></Destinations>}></Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
