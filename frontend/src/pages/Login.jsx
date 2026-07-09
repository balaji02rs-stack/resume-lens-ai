import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { login } from "../services/authService";

import {
  Box,
  Grid,
  Paper,
  TextField,
  InputAdornment,
  IconButton,
  Button,
  Typography,
  Checkbox,
  FormControlLabel,
  Divider,
  Stack,
  useTheme,
  alpha,
  Alert,
} from "@mui/material";

import { motion } from "framer-motion";

import {
  FiMail,
  FiLock,
  FiEye,
  FiEyeOff,
  FiArrowRight,
} from "react-icons/fi";

import { FcGoogle } from "react-icons/fc";
import { BsGithub } from "react-icons/bs";

function Login() {
  const theme = useTheme();
  const isDark = theme.palette.mode === "dark";

  const navigate = useNavigate();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const [showPassword, setShowPassword] = useState(false);
  const [rememberMe, setRememberMe] = useState(false);

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    setLoading(true);
    setError("");

    try {
      const response = await login({
        email,
        password,
      });

      localStorage.setItem("token", response.token);

      navigate("/dashboard");
    } catch (err) {
      setError(
        err?.response?.data?.message ||
          "Invalid email or password."
      );
    } finally {
      setLoading(false);
    }
  };

  return (
    <Grid container sx={{ minHeight: "100vh" }}>
      <Grid
        item
        xs={0}
        md={7}
        sx={{
          display: { xs: "none", md: "flex" },
          position: "relative",
          alignItems: "center",
          justifyContent: "center",
          overflow: "hidden",
          backgroundImage:
            "linear-gradient(135deg,#4F46E5 0%,#7C3AED 100%)",
        }}
      >
        <motion.div
          animate={{
            y: [0, 30, 0],
            x: [0, 20, 0],
          }}
          transition={{
            duration: 10,
            repeat: Infinity,
            ease: "easeInOut",
          }}
          style={{
            position: "absolute",
            top: "10%",
            left: "10%",
            width: 280,
            height: 280,
            borderRadius: "50%",
            background: alpha("#fff", 0.12),
            filter: "blur(10px)",
          }}
        />

        <motion.div
          animate={{
            y: [0, -40, 0],
            x: [0, -25, 0],
          }}
          transition={{
            duration: 12,
            repeat: Infinity,
            ease: "easeInOut",
          }}
          style={{
            position: "absolute",
            bottom: "15%",
            right: "12%",
            width: 220,
            height: 220,
            borderRadius: "50%",
            background: alpha("#10B981", 0.25),
            filter: "blur(10px)",
          }}
        />

        <motion.div
          animate={{
            rotate: 360,
          }}
          transition={{
            duration: 30,
            repeat: Infinity,
            ease: "linear",
          }}
          style={{
            position: "absolute",
            width: 420,
            height: 420,
            borderRadius: "50%",
            border: `1px dashed ${alpha("#fff",0.2)}`,
          }}
        />

        <Box
          sx={{
            position: "relative",
            zIndex: 2,
            textAlign: "center",
            px: 8,
          }}
        >
          <motion.div
            animate={{
              y: [0, -10, 0],
            }}
            transition={{
              duration: 4,
              repeat: Infinity,
              ease: "easeInOut",
            }}
          >
            <Box
              sx={{
                width: 82,
                height: 82,
                borderRadius: "24px",
                mx: "auto",
                mb: 4,
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                background: alpha("#fff",0.18),
                backdropFilter: "blur(10px)",
                border: `1px solid ${alpha("#fff",0.25)}`,
              }}
            >
              <Typography
                sx={{
                  fontWeight: 800,
                  fontSize: 32,
                  color: "#fff",
                }}
              >
                RL
              </Typography>
            </Box>

            <Typography
              variant="h2"
              sx={{
                color: "#fff",
                fontWeight: 700,
                mb: 2,
              }}
            >
              ResumeLens AI
            </Typography>

            <Typography
              sx={{
                color: alpha("#fff",0.92),
                maxWidth: 430,
                mx: "auto",
                lineHeight: 1.9,
                fontSize: "1.1rem",
              }}
            >
              AI-powered resume analysis with ATS scoring,
              job matching, intelligent insights, and
              recruiter-ready recommendations.
            </Typography>
          </motion.div>
        </Box>
      </Grid>

      <Grid
        item
        xs={12}
        md={5}
        sx={{
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
          px: 4,
          py: 6,
          background:
            "linear-gradient(135deg,#F8FAFC,#EEF2FF)",
        }}
      >
        <motion.div
          initial={{
            opacity: 0,
            scale: .92,
            y: 40,
          }}
          animate={{
            opacity: 1,
            scale: 1,
            y: 0,
          }}
          transition={{
            duration: .75,
            ease: "easeOut",
          }}
          style={{
            width: "100%",
            maxWidth: 470,
          }}
        >
          <Paper
            component="form"
            elevation={0}
            onSubmit={handleSubmit}
            sx={{
              p: { xs: 4, sm: 5 },
              borderRadius: "28px",
              backdropFilter: "blur(16px)",
              border: `1px solid ${
                isDark
                  ? alpha("#fff",0.08)
                  : alpha("#111827",0.06)
              }`,
              background: isDark
                ? alpha("#1E293B",0.6)
                : alpha("#fff",0.88),
              boxShadow: isDark
                ? "0 20px 60px rgba(0,0,0,.45)"
                : "0 20px 60px rgba(15,23,42,.12)",
            }}
          >
            <Typography
              variant="h3"
              fontWeight={700}
              sx={{ mb: 1 }}
            >
              Welcome Back
            </Typography>

            <Typography
              sx={{
                mb: 5,
                fontSize: "1rem",
              }}
              color="text.secondary"
            >
              Login to continue to ResumeLens AI.
            </Typography>

            <Stack spacing={2.5}>

              {error && (
                <Alert severity="error">
                  {error}
                </Alert>
              )}

              <TextField
                fullWidth
                label="Email"
                value={email}
                onChange={(e)=>
                  setEmail(e.target.value)
                }
                sx={{
                  "& .MuiOutlinedInput-root":{
                    borderRadius:"14px"
                  }
                }}
                InputProps={{
                  startAdornment:(
                    <InputAdornment position="start">
                      <FiMail/>
                    </InputAdornment>
                  )
                }}
              />

              <TextField
                fullWidth
                label="Password"
                type={
                  showPassword
                    ? "text"
                    : "password"
                }
                value={password}
                onChange={(e)=>
                  setPassword(e.target.value)
                }
                sx={{
                  "& .MuiOutlinedInput-root":{
                    borderRadius:"14px"
                  }
                }}
                InputProps={{
                  startAdornment:(
                    <InputAdornment position="start">
                      <FiLock/>
                    </InputAdornment>
                  ),
                  endAdornment:(
                    <InputAdornment position="end">
                      <IconButton
                        onClick={()=>
                          setShowPassword(!showPassword)
                        }
                      >
                        {showPassword
                          ? <FiEyeOff/>
                          : <FiEye/>}
                      </IconButton>
                    </InputAdornment>
                  )
                }}
              />              <Box
                sx={{
                  display: "flex",
                  justifyContent: "space-between",
                  alignItems: "center",
                }}
              >
                <FormControlLabel
                  control={
                    <Checkbox
                      checked={rememberMe}
                      onChange={(e) =>
                        setRememberMe(e.target.checked)
                      }
                    />
                  }
                  label="Remember Me"
                />

                <Typography
                  component={Link}
                  to="#"
                  sx={{
                    color: "primary.main",
                    textDecoration: "none",
                    fontWeight: 600,
                    "&:hover": {
                      textDecoration: "underline",
                    },
                  }}
                >
                  Forgot Password?
                </Typography>
              </Box>

              <Button
                type="submit"
                variant="contained"
                disabled={loading}
                endIcon={<FiArrowRight />}
                sx={{
                  py: 1.7,
                  borderRadius: "16px",
                  textTransform: "none",
                  fontWeight: 700,
                  fontSize: "1rem",
                  transition: "all .35s ease",

                  "&:hover": {
                    transform: "translateY(-3px)",
                    boxShadow:
                      "0 18px 35px rgba(37,99,235,.35)",
                  },
                }}
              >
                {loading
                  ? "Signing In..."
                  : "Sign In"}
              </Button>

              <Divider>
                <Typography
                  variant="caption"
                  color="text.secondary"
                >
                  OR CONTINUE WITH
                </Typography>
              </Divider>

              <Stack direction="row" spacing={2}>
                <Button
                  fullWidth
                  variant="outlined"
                  startIcon={<FcGoogle />}
                  sx={{
                    py: 1.2,
                    borderRadius: "14px",
                    textTransform: "none",
                  }}
                >
                  Google
                </Button>

                <Button
                  fullWidth
                  variant="outlined"
                  startIcon={<BsGithub />}
                  sx={{
                    py: 1.2,
                    borderRadius: "14px",
                    textTransform: "none",
                  }}
                >
                  GitHub
                </Button>
              </Stack>

              <Typography
                align="center"
                color="text.secondary"
              >
                Don't have an account?{" "}

                <Box
                  component={Link}
                  to="/register"
                  sx={{
                    color: "primary.main",
                    fontWeight: 700,
                    textDecoration: "none",

                    "&:hover": {
                      textDecoration: "underline",
                    },
                  }}
                >
                  Create One
                </Box>
              </Typography>
            </Stack>
          </Paper>
        </motion.div>
      </Grid>
    </Grid>
  );
}

export default Login;