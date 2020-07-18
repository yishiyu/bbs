import axios from "axios";
import Qs from "qs";
export const register = (userName, userPassword, userEmail) => {
  return axios.post(
    "/register",
    Qs.stringify({ userName, userPassword, userEmail })
  );
};
