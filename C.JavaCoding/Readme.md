# How to run

## Clone the repo

```bash
git clone https://github.com/Ruhshan/assignment-ebi.git
```

## Navigate to Code directory
```bash
cd assignment-ebi/C.JavaCoding
```

## Build docker image
```bash
docker build -f Dockerfile -t java-coding .  
```

## Run the answer code for Question1
```bash
docker run -it --rm java-coding java Question1   
```
If codes are updated, building the image is necessary to reflect the changes.
