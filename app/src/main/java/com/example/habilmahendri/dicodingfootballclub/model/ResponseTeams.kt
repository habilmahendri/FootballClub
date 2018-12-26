package com.example.habilmahendri.dicodingfootballclub.model

import com.google.gson.annotations.SerializedName

class ResponseTeams (
        @SerializedName("teams")var teams:List<Team>
)