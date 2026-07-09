import { useState } from "react";
import axios from "axios";

function UploadResume() {

  const [file, setFile] = useState(null);

  const [jobDescription, setJobDescription] = useState("");

  const [analysis, setAnalysis] = useState(null);

  const [loading, setLoading] = useState(false);

  const handleUpload = async () => {

    if (!file) {
      alert("Please select a resume.");
      return;
    }

    if (!jobDescription.trim()) {
      alert("Please enter a job description.");
      return;
    }

    const formData = new FormData();

    formData.append("file", file);
    formData.append("jobDescription", jobDescription);

    try {

      setLoading(true);

      const token = localStorage.getItem("token");

      const response = await axios.post(

        "https://resume-lens-backend-bxb8.onrender.com/api/resume/analyze",

        formData,

        {
          headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "multipart/form-data",
          },
        }

      );

      setAnalysis(response.data);

    } catch (error) {

      console.error(error);

      alert("Analysis failed.");

    } finally {

      setLoading(false);

    }

  };

  return (

    <div className="container mt-5">

      <h2 className="mb-4">
        Resume Analysis
      </h2>

      <div className="card shadow p-4 mb-4">

        <div className="mb-3">

          <label className="form-label">
            Resume
          </label>

          <input
            type="file"
            className="form-control"
            accept=".pdf"
            onChange={(e) => setFile(e.target.files[0])}
          />

        </div>

        <div className="mb-3">

          <label className="form-label">
            Job Description
          </label>

          <textarea
            className="form-control"
            rows="8"
            value={jobDescription}
            onChange={(e) =>
              setJobDescription(e.target.value)
            }
            placeholder="Paste the job description here..."
          />

        </div>

        <button
          className="btn btn-primary"
          onClick={handleUpload}
          disabled={loading}
        >

          {loading
            ? "Analyzing..."
            : "Analyze Resume"}

        </button>

      </div>

      {analysis && (

        <div className="card shadow p-4">

          <h3 className="mb-4">
            Analysis Result
          </h3>

          <table className="table">

            <tbody>

              <tr>
                <th>File</th>
                <td>{analysis.fileName}</td>
              </tr>

              <tr>
                <th>ATS Score</th>
                <td>{analysis.atsScore}%</td>
              </tr>

              <tr>
                <th>Job Match</th>
                <td>{analysis.jobMatchScore}%</td>
              </tr>

              <tr>
                <th>Uploaded</th>
                <td>{analysis.uploadedAt}</td>
              </tr>

              <tr>
                <th>Saved</th>
                <td>{analysis.saved ? "Yes" : "No"}</td>
              </tr>

            </tbody>

          </table>

          <hr />

          <h4>Skills</h4>

          <ul>

            {analysis.skills.map((skill, index) => (

              <li key={index}>
                {skill}
              </li>

            ))}

          </ul>

          <hr />

          <h4>Education</h4>

          <ul>

            {analysis.education.map((item, index) => (

              <li key={index}>
                {item}
              </li>

            ))}

          </ul>

          <hr />

          <h4>Experience</h4>

          <ul>

            {analysis.experience.map((item, index) => (

              <li key={index}>
                {item}
              </li>

            ))}

          </ul>

        </div>

      )}

    </div>

  );

}

export default UploadResume;