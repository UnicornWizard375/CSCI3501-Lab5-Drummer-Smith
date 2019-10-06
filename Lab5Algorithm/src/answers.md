# Our Algorithm
The algorithm that we have created uses randomization to generate pairings
based on the amount of companies/programmers we have given it.
This means that generating a satisfactory pairing is highly dependent on the number of companies/programmers,
and the allowed amount that the algorithm can generate pairings.
Lower amounts for companies/programmers and high generation amounts will usually lead to a satisfactory pairing being generated.
Low generation with moderate to high amounts of companies/programmers means that usually a satisfactory pairing will not be generated.
This makes our algorithm not the best for large amounts of data, unless you let the algorithm run on basically infinite generations,
even then you aren't guaranteed to get a satisfactory pairing due to the probability of a satisfactory pairing getting smaller
as the amount of companies/programmers increases.
Hence, our worst case efficiency is infinite run time.


# Test Data

We ran the following tests on our algorithm, ranging from 0 companies and people given, to 9 given.
Each was allowed to generate 10,000 pairings before automatically stopping.




####0 companies

generated 0 random pairs before reaching a satisfactory pairing
Final pairing: [] <br/>
is this satisfactory: true

####1 company
Companies
Company A: [1] <br/>

Programmer

Programmer 1: [A] <br/>
generated 0 random pairs before reaching a satisfactory pairing
Final pairing: [A1] <br/>
is this satisfactory: true

####2 companies

Companies
Company A: [1, 2] <br/>
Company B: [1, 2] <br/>

Programmer

Programmer 1: [A, B] <br/>
Programmer 2: [B, A] <br/>
generated 0 random pairs before reaching a satisfactory pairing
Final pairing: [A1, B2] <br/>
is this satisfactory: true

####3 Companies

Companies
Company A: [3, 1, 2] <br/>
Company B: [3, 1, 2] <br/>
Company C: [1, 2, 3] <br/>

Programmer

Programmer 1: [A, B, C] <br/>
Programmer 2: [A, C, B] <br/>
Programmer 3: [C, A, B] <br/>
generated 1 random pairs before reaching a satisfactory pairing
Final pairing: [A3, B2, C1] <br/>
is this satisfactory: true

####4 companies
Companies
Company A: [3, 2, 4, 1] <br/>
Company B: [1, 2, 4, 3] <br/>
Company C: [1, 3, 2, 4] <br/>
Company D: [1, 2, 3, 4] <br/>

Programmers

Programmer 1: [C, D, B, A] <br/>
Programmer 2: [B, D, A, C] <br/>
Programmer 3: [D, B, C, A] <br/>
Programmer 4: [C, A, B, D] <br/>
generated 8 random pairs before reaching a satisfactory pairing
Final pairing: [A3, B4, C1, D2] <br/>
is this satisfactory: true

####5 Companies 
Companies
Company A: [3, 2, 4, 5, 1] <br/>
Company B: [4, 1, 3, 5, 2] <br/>
Company C: [4, 2, 5, 3, 1] <br/>
Company D: [4, 5, 3, 1, 2] <br/>
Company E: [1, 4, 2, 5, 3] <br/>

Programmers

Programmer 1: [D, B, C, A, E] <br/>
Programmer 2: [E, D, B, C, A] <br/>
Programmer 3: [B, A, C, D, E] <br/>
Programmer 4: [B, D, E, A, C] <br/>
Programmer 5: [B, E, A, C, D] <br/>
generated 7 random pairs before reaching a satisfactory pairing
Final pairing: [A3, B4, C2, D5, E1] <br/>
is this satisfactory: true

####6 companies

Companies
Company A: [4, 1, 3, 2, 6, 5] <br/>
Company B: [5, 1, 2, 3, 6, 4] <br/>
Company C: [3, 4, 1, 5, 6, 2] <br/>
Company D: [6, 1, 4, 2, 3, 5] <br/>
Company E: [3, 6, 5, 4, 1, 2] <br/>
Company F: [2, 1, 5, 3, 4, 6] <br/>

Programmers

Programmer 1: [A, C, D, E, B, F] <br/>
Programmer 2: [C, E, A, B, F, D] <br/>
Programmer 3: [C, E, B, D, A, F] <br/>
Programmer 4: [A, B, D, F, E, C] <br/>
Programmer 5: [F, B, E, A, C, D] <br/>
Programmer 6: [D, B, F, A, E, C] <br/>
generated 171 random pairs before reaching a satisfactory pairing
Final pairing: [A1, B5, C4, D6, E3, F2] <br/>
is this satisfactory: true

####7 companies

Companies
Company A: [2, 4, 7, 1, 3, 6, 5] <br/>
Company B: [4, 7, 2, 3, 5, 1, 6] <br/>
Company C: [2, 7, 6, 4, 3, 1, 5] <br/>
Company D: [2, 6, 1, 3, 4, 7, 5] <br/>
Company E: [6, 2, 3, 5, 4, 7, 1] <br/>
Company F: [4, 1, 3, 7, 6, 5, 2] <br/>
Company G: [6, 3, 4, 5, 2, 1, 7] <br/>

Programmers

Programmer 1: [E, B, G, C, D, F, A] <br/>
Programmer 2: [E, F, C, A, G, B, D] <br/>
Programmer 3: [F, E, D, C, A, B, G] <br/>
Programmer 4: [B, A, E, D, C, G, F] <br/>
Programmer 5: [C, G, E, A, D, F, B] <br/>
Programmer 6: [C, D, B, E, A, F, G] <br/>
Programmer 7: [B, F, C, A, E, G, D] <br/>
generated 1104 random pairs before reaching a satisfactory pairing
Final pairing: [A2, B4, C7, D1, E5, F3, G6] <br/>
is this satisfactory: true

####8 Companies

Companies
Company A: [5, 7, 6, 8, 3, 2, 1, 4] <br/>
Company B: [2, 5, 3, 1, 7, 8, 6, 4] <br/>
Company C: [1, 3, 4, 6, 7, 2, 8, 5] <br/>
Company D: [8, 3, 4, 5, 2, 7, 1, 6] <br/>
Company E: [1, 5, 6, 2, 4, 3, 7, 8] <br/>
Company F: [7, 5, 1, 6, 3, 8, 4, 2] <br/>
Company G: [1, 7, 4, 3, 5, 2, 6, 8] <br/>
Company H: [7, 5, 6, 8, 2, 1, 4, 3] <br/>

Programmers

Programmer 1: [G, B, A, D, E, H, F, C] <br/>
Programmer 2: [C, E, A, G, H, F, B, D] <br/>
Programmer 3: [E, G, F, C, A, H, D, B] <br/>
Programmer 4: [B, H, A, D, C, E, G, F] <br/>
Programmer 5: [B, C, E, G, D, A, F, H] <br/>
Programmer 6: [G, D, B, A, C, H, E, F] <br/>
Programmer 7: [F, D, H, C, A, G, B, E] <br/>
Programmer 8: [D, B, A, E, F, C, H, G] <br/>
generated 252 random pairs before reaching a satisfactory pairing
Final pairing: [A5, B2, C3, D4, E6, F7, G1, H8] <br/>
is this satisfactory: true

####9 Companies

Companies
Company A: [1, 5, 4, 9, 8, 2, 6, 3, 7] <br/>
Company B: [3, 9, 4, 6, 5, 1, 8, 2, 7] <br/>
Company C: [7, 1, 4, 8, 6, 9, 5, 3, 2] <br/>
Company D: [2, 1, 4, 6, 9, 5, 7, 3, 8] <br/>
Company E: [9, 2, 4, 5, 3, 6, 7, 8, 1] <br/>
Company F: [9, 3, 5, 6, 4, 1, 8, 7, 2] <br/>
Company G: [5, 3, 2, 7, 1, 8, 6, 4, 9] <br/>
Company H: [3, 8, 6, 4, 7, 5, 1, 9, 2] <br/>
Company I: [8, 4, 9, 5, 6, 2, 3, 7, 1] <br/>

Programmers

Programmer 1: [F, I, A, H, G, B, E, D, C] <br/>
Programmer 2: [C, G, D, H, B, F, I, A, E] <br/>
Programmer 3: [G, B, C, H, D, F, E, A, I] <br/>
Programmer 4: [D, I, B, A, H, C, F, G, E] <br/>
Programmer 5: [G, H, C, I, F, D, B, E, A] <br/>
Programmer 6: [F, D, H, A, I, E, B, C, G] <br/>
Programmer 7: [I, A, B, D, E, F, C, H, G] <br/>
Programmer 8: [A, I, D, E, B, C, H, G, F] <br/>
Programmer 9: [E, C, D, H, B, I, A, G, F] <br/>
Final pairing: [A1, B3, C7, D6, E5, F9, G2, H8, I4] <br/>
is this satisfactory: false

Notice this one did not find a satisfactory pair in the 10,000 runs we performed