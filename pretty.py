import csv
from collections import  defaultdict
from csv import DictReader


killed_mutants_dir = "mutation_results/killed.csv"
summary_mutants_dir = "mutation_results/summary.csv"
log_mutants_path = "mutation_results/mutants.log"

def read_summary():
	global summary_dict
	summary_dict = {}
	with open(summary_mutants_dir) as f:
		reader = DictReader(f)
		summary_dict = reader.next()
		for k, v in summary_dict.iteritems():
    			print k, v
	print((summary_dict))

def read_killed():
	global killed_dict
	killed_dict = {}
	with open(killed_mutants_dir) as f:
		reader = csv.DictReader(f);
		for row in reader:
			killed_dict[row['MutantNo']] = row['[FAIL | TIME | EXC | LIVE]']
	print(killed_dict)

def read_diff():
	global diffs_dict
	diffs_dict = {}
	with open(log_mutants_path) as f:
		#reader = csv.DictReader(f)
		rows = f.readlines()
		for row in rows:
			temp = row.split(":")
			diffs = temp[6].split("|==>")
			diffs_dict[temp[0]] = [temp[1],temp[5],diffs[0],diffs[1].rstrip()]
	print(diffs_dict['125'])
	print(len(diffs_dict))

def main():
	read_summary()
	read_killed()
	read_diff()
main()
