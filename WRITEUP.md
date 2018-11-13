# Writeup
I used the provided script to have multiple clients call the server at the same time(ish). I'm logged in to acrylic, which has 4 cores and 8gb RAM.

I used test/etc/pumpkins.jpg as the file. It's not a VERY big file, but I figured it would work if I made enough calls. The game would change a bit with larger files, since each thread would take longer, but I think the idea is the same since we're trying to cause competition for the server.

Based on the results below, until the machine starts affecting performance in unrelated ways (like running out of memory), the runtime increases pretty much linearly with increasing the number of calls made.

## Thread pool size 16
| # of Calls | Time (s) |
| --- | --- |
| 100 | 10 |
| 200 | 22 |
| 300 | 32 |
| 400 | 43 |
| 500 | 79 |

Cores saturated nicely.

The machine froze on the call for 500 for a little bit. :P Like you said in the readme, the script makes all the calls on the local machine. When I looked at mem usage in System Monitor, it was pretty much all in use.

## Thread pool size 8
| ---: | ---: |
| # of Calls | Time (s) |
| 100 | 12 |
| 200 | 22 |
| 300 | 31 |

Froze on 200 calls, not sure why. Could've been other factors. On 300 calls, there was a small dip in CPU usage (down to 70-80%) at one point, but it didn't change the overall runtime much compared to equivalent run w/ thread pool size 16.
